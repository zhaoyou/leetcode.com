### Minimax 算法

> 以棋类游戏为例来说明 minimax 算法，每一个棋盘的状态都会对应一个分数。双方将会轮流下棋。
轮到我方下子时，我会选择分数最高的状态；而对方会选择对我最不利的状态。可以这么认为，
每次我都需要从对手给我选择的最差（min）局面中选出最好（max）的一个，这就是这个算法名称 minimax 的意义。

### Reference

- http://www.wukai.me/2018/03/04/minimax-alpha-beta-pruning-and-tic-tac-toe/
- https://github.com/noiron/tic-tac-toe-js/blob/master/algorithms/minimax.js
https://github.com/noiron/tic-tac-toe-js/blob/master/algorithms/alphabeta.js