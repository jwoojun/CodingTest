import sys

input = sys.stdin.readline

N = int(input())
P = int(input())


def find_parent(x, parent):
    if parent[x] != x:
        parent[x] = find_parent(parent[x], parent)
    return parent[x]


def union_parent(parent, x, y):
    x = find_parent(x, parent)
    y = find_parent(y, parent)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y
