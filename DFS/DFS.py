"""
DFS 是常见的深度优先搜索算法（Depth-First-Search），是一种利用递归实现的搜索算法。
深度探索所有元素
"""

# init the graphs data
graphs = {
    'A': ['B', 'C'],
    'B': ['A', 'C', 'D'],
    'C': ['A', 'B', 'D', 'E'],
    'D': ['B', 'C', 'E', 'F'],
    'E': ['C', 'D'],
    'F': ['D']
}


def dfs(graph, s):
    """
    we use stack to do dfs
    :param graph: graph data
    :param s: start node
    :return: the dfs data
    """
    stack = [s]
    visited = [s]
    while len(stack) > 0:
        vertex = stack.pop()
        nodes = graph[vertex]
        for n in nodes:
            if n not in visited:
                stack.append(n)
        if vertex not in visited:
            visited.append(vertex)
    return visited


def dfs_target(graph, s, e):
    """
    use dfs find the shortest path
    :param graph: graph data
    :param s: start node
    :param e: end node
    :return: the path from start to end
    """
    stack = [s]
    visited = [s]
    find = False
    while len(stack) > 0:
        vertex = stack.pop()
        nodes = graph[vertex]
        for n in nodes:
            if n not in visited:
                stack.append(n)
            if n == e:
                find = True
        if vertex not in visited:
            visited.append(vertex)
        if find:
            break
    visited.append(e)
    return visited


if __name__ == '__main__':
    print(dfs(graphs, 'A'))
    print(dfs_target(graphs, 'A', 'D'))

