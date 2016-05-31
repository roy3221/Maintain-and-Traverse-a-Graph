## Running Instruction:
Please run the program from Implement/Run.java;
You can change the input under: inputs/Input;
The output will be outputs/Output

## write up:


### What is the memory footprint for your approach? What is the running time for each add link, remove link, and is linked?

Answer:
Use a Adjacent list implemented with hashMap, which will need O(n*deg(n)) memory space, where n is number of nodes, deg(n) is the maximum number of neighbors of all nodes.
Use a Set to maintain all links, which will take O(e) memory space, where e is the number of links.


### Our application has too many nodes to keep them all in memory on one machine. How would you handle this in a real world application? There are many ways to approach this issue, but if you choose to go the database route please describe which database, your tables, indexes, queries, and performance. If you have another approach, please describe it in detail.

Answer:
if there too many node to store in memory. We can use distributed database to maintain the graph and links, like using HBase.

I think we just need two tables, let's say Table "graph":

node  neighbors
1		[1,2,3]
2		[1,2]
3		[1,3]
......

each row represents a node and its neighbors.


Table "links":

node1	node2
1		2
1		1
2		2
1		3
3		1
......

each row represents a pair linked nodes in graph.

When using HBase, we can use hadoop MapReduce framework to deal with the table of links in multiple PC. The number of PC depends on the size of data.

For queries of "add" and "remove", we need to update the table links each time. The performance depends on how many slaves we configured in HBase.

For query "is linked", we can still have a constant time performance, since the table "links" maintains all links in the graph, we just need to check if the pair of nodes (create a rowKey of each pair of nodes based on creating a hashcode of them.) is in the table "links" or not.


