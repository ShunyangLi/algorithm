"""
Name: http.py
Author: lsy
Time: 2020/5/23
"""

from socket import *

if __name__ == '__main__':
    # AF_INET：socket默认使用IPV4链接
    # SOCK_STREAM：数据流式（TCP）
    # SOCK_DGRAM：数据报式（UDP）
    server = socket(AF_INET, SOCK_STREAM)
    # binding IP and port
    server.bind(("127.0.0.1", 8000))
    # 表示可以同时接受5个请求，然后逐个处理，如果超过5个直接reject
    server.listen(5)
    while True:
        # 接受客户端的请求
        new_client, client_add = server.accept()
        print("IP: {} is requesting".format(client_add))
        request = new_client.recv(1024)
        print("Get request: {}".format(request))