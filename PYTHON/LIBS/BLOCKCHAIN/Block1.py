
import hashlib
import random
import string
import time


class Block1:

    def __init__(self, data, prev_hash):
        self.data = data
        self.prev_hash = prev_hash
        self.utc = time.time()

        self.block_hash = self.hash_256( self.prev_hash + str(self.utc) + str(self.data) )

   
    #############################################################################

    def hash_256(self, in_str):

        hex_hash = ""
        
        hash_bytes = (hashlib.sha256(in_str.encode()).hexdigest())

        index = 0

        while index < len( hash_bytes ):
            b = hex(ord(hash_bytes[index]) & 0xff)

            if len(b) == 1:
                hex_hash += '0'

            hex_hash += b

            index += 1

        return str(hex_hash)


    #############################################################################


class GenChain:

    def get_next_data(data_size, file_pointer=None):

        if file_pointer is None:
            return (''.join(random.choices(string.printable, k=data_size)))

        else:
            return None

    ###########################################

    def get_chain(n_blocks, data_size=512, file_pointer=None):
        
        bc = []

        index = 0

        prev_hash = "0"

        while index < n_blocks:

            next_data = GenChain.get_next_data(data_size, file_pointer)

            b = Block1(next_data, prev_hash)

            bc.append(b)

            prev_hash = b.block_hash

            index += 1

        return bc

    #######################################################
        

    def is_consistent(bc):

        prev_hash = "0"

        for b in bc:

            if b.prev_hash != prev_hash:
                return False

            if b.block_hash != b.hash_256(str(b.prev_hash) + str(b.utc) + str(b.data)):
                return False

            prev_hash = b.block_hash

        return True


################################################################################################

b1c = GenChain.get_chain(10, 128)

print("Is blockchain original: {}".format(GenChain.is_consistent(b1c)))


