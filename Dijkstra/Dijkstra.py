"""
Dijkstra 最短路径算法
使用priority queue的数据结构来完整该算法，根据每一个node的priority来实现的
谁的priority大，谁在前面。
Python有priority queue可以直接使用
"""

import heapq
import math

graphs = {
    'A': {'B': 5, 'C': 1},
    'B': {'A': 5, 'C': 2, 'D': 1},
    'C': {'A': 1, 'B': 2, 'D': 4, 'E': 8},
    'D': {'B': 1, 'C': 4, 'E': 3, 'F': 6},
    'E': {'C': 8, 'D': 3},
    'F': {'D': 6}
}


def init_distance(graph, s):
    """

    :param graph:
    :param s:
    :return:
    """
    distance = {s: 0}
    for vertex in graph:
        if vertex != s:
            distance[vertex] = math.inf
    return distance


def dijkstra(graph, s):
    """
    find the shortest way
    :param graph: graph data
    :param s: start node
    :return:
    """
    pq = []
    visited = set()
    parent = {s: None}
    distance = init_distance(graph, s)
    heapq.heappush(pq, (0, s))

    while len(pq) > 0:
        pair = heapq.heappop(pq)
        dist = pair[0]
        vertex = pair[1]
        visited.add(vertex)

        nodes = graph[vertex].keys()
        for node in nodes:
            if node not in visited:
                total_dist = dist + graph[vertex][node]
                if total_dist < distance[node]:
                    heapq.heappush(pq, (total_dist, node))
                    parent[node] = vertex
                    distance[node] = total_dist

    return distance, parent


if __name__ == '__main__':
    print(dijkstra(graphs, 'A'))

