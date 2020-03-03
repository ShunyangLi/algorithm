"""
BFS 是常见的广度优先搜索算法（Breadth-First-Search），是一种利用队列实现的搜索算法。
先探索其实点周的node，像四周扩散
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


def bfs(graph, s):
    """
    implement the bfs
    :param graph: graph data
    :param s: start node
    :return:
    """
    # we use queue in bfs
    queue = [s]
    visited = [s]
    while len(queue) > 0:
        vertex = queue.pop(0)
        nodes = graph[vertex]
        for n in nodes:
            if n not in visited:
                queue.append(n)
                visited.append(n)
    return visited


def bfs_target(graph, s, e):
    """
    use bfs find the shortest path
    :param graph: graph data
    :param s: start node
    :param e: end node
    :return: the shortest path from s to e
    """
    queue = [s]
    visited = [s]
    find = False
    while len(queue) > 0:
        vertex = queue.pop(0)
        nodes = graph[vertex]
        for n in nodes:
            if n not in visited:
                queue.append(n)
                visited.append(n)
            if n == e:
                find = True
                break
        if find:
            break
    return visited


if __name__ == '__main__':
    print(bfs(graphs, 'A'))
    print(bfs_target(graphs, 'A', 'D'))
