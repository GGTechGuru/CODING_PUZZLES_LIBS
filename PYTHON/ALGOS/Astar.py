# Algorithm: A*/Astar fastest search for path between nodes in a graph
# Implementor: Gerard Gold (669) 254-9474

# Combined files, so commenting out.
# from graph_type_1 import Graph_Type_1
# from graph_adapter import Graph_Adapter

def astar(g, graph_type, start_name, end_name):

    print("Astar from {0} to {1}".format(start_name, end_name))

    closed_set = set()
    open_set = set()

    node_f = {}
    node_g = {}
    node_h = {}

    node_parent = {}

    ga = Graph_Adapter(g, graph_type)

    cur_name = start_name

    open_set.add(cur_name)

    while (cur_name != end_name):

        node_f[cur_name] = node_g[cur_name] = node_h[cur_name] = 0

        adj_names = ga.get_adj_names(cur_name)

        max_f = 0
        for maybe in adj_names:

            if maybe in closed_set:
                continue

            g_val = (ga.get_x(cur_name)-ga.get_x(maybe))**2 + (ga.get_y(cur_name)-ga.get_y(maybe))**2

            h_val = (ga.get_x(end_name)-ga.get_x(maybe))**2 + (ga.get_y(end_name)-ga.get_y(maybe))**2

            f_val = g_val + h_val

            if f_val > max_f:
                max_f = f_val

            if (maybe in open_set) and (node_f[maybe] < f_val):
                continue

            node_g[maybe] = g_val
            node_h[maybe] = h_val
            node_f[maybe] = f_val

            print("NODE_F:" , node_f)


            if (maybe not in open_set) and (maybe not in closed_set):
                open_set.add(maybe)

            node_parent[maybe] = cur_name


        closed_set.add(cur_name)
        open_set.remove(cur_name)

        if len(open_set) <= 0:
            break

        min_f = max_f
        min_name = None
        for maybe in open_set:

            print("MAYBE:", maybe)

            if (node_parent[maybe] in closed_set) and (node_f[maybe] <= min_f):
                min_f = node_f[maybe]
                min_name = maybe


        if min_name is None:
            break
        else:
            cur_name = min_name

        print("NODE_PARENT: ", node_parent)
        print("OPEN_SET: ", open_set)
        print("CLOSED_SET: ", closed_set)
        print("CUR_NAME:", cur_name)


    if cur_name != end_name:
        print("CUR_NAME {0}!= END_NAME {1} ".format(cur_name, end_name))
        return None

    path_list = []
    cur_name = end_name
    while cur_name != start_name:
        print("NODE_PARENT: ", node_parent)
        print("CUR_NAME:", cur_name)
        print("PATH_LIST:" , path_list)

        path_list.append(cur_name)
        next_par = node_parent[cur_name]
        del node_parent[cur_name]
        cur_name = next_par



    if cur_name == start_name:
        path_list.append(cur_name)
    else:
        print("CUR_NAME {0}!= START_NAME {1} ".format(cur_name, start_name))
        return None

    print("PATH_LIST:" , path_list)

    path_list.reverse()
    return path_list

# Adapter class for various graph implementations

from graph_type_1 import Graph_Type_1

class Graph_Adapter:

    def __init__(self, ginst, graph_type=1):
        self.graph_type = graph_type
        self.ginst = ginst

    def node_by_name(self, node_name):
        if self.graph_type == 1:
            return self.ginst.all_nodes[node_name]

    def get_adj_names(self, node_name):
        if self.graph_type == 1:
            return self.ginst.all_nodes[node_name].adjacent_names

    def get_x(self, node_name):
        if self.graph_type == 1:
            ref_node = self.ginst.all_nodes[node_name]
            return ref_node.x

    def get_y(self, node_name):
        if self.graph_type == 1:
            ref_node = self.ginst.all_nodes[node_name]
            return ref_node.y


##################################
# Graph implementation with adjacency lists

class Graph_T1_Node:
    def __init__(self, node_name, x, y, adjacent_names):
        self.adjacent_names = adjacent_names

        self.node_name = node_name

        self.x = x
        self.y = y

        self.g = self.h = self.f = 0


class Graph_Type_1:

    def __init__(self):
        self.all_nodes = {}

    def add_node(self, node_name, x, y, adjacent_names):

        gn = Graph_T1_Node(node_name, x, y, adjacent_names)

        self.all_nodes[gn.node_name] = gn


    def disp(self, start_node=None):
        nodes_seen = {}

        for node_name in self.all_nodes.keys():

            cur_node = self.all_nodes[node_name]

            if cur_node.node_name in nodes_seen.keys():
                continue

            nodes_seen[node_name] = cur_node

            print("Node name {2}: x->{0}, y->{1}".format( cur_node.x, cur_node.y, node_name) )

            adjs = cur_node.adjacent_names

            print("Adjacent nodes:")
            for adj_name in adjs:
               print(adj_name)




