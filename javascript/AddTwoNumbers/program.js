
 /**
 *Definition for singly-linked list.
 */
 var ListNode = function(val) {
      this.val = val;
      this.next = null;
 }

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {

	if (!l1 || !l2) { return null;}

	var a = l1.val + l2.val;
	var bu = parseInt(a / 10);
	a = a % 10;
	var resultNode = new ListNode(a);

	var current = resultNode;


	var node1 = l1.next;
	var node2 = l2.next;

	while(node1 ||  node2) {
		a = (node1 && node1.val) + (node2 && node2.val) + bu;
		// 获取数量之和 + 上一次的进位
		bu = parseInt(a /10)

		a = a % 10;

		var nextNode = new ListNode(a)

		current.next = nextNode;
		current = nextNode;

	    node1 = node1 && node1.next;
	    node2 = node2 && node2.next;
	}

	if (bu) {current.next = new ListNode(bu);}

    return resultNode;
};

function buildNodeList(arr) {
  if (!arr || !arr.length) { return null;}
  var result = new ListNode(arr[0]);
  var i = 1, len = arr.length;
  var next = null;
  var current = result;
  for(; i < len; i++) {
    next = new ListNode(arr[i]);
    current.next = next;
    current = next;
  }
  return result;
}

console.log(buildNodeList([3,4,2,5]));
console.log(buildNodeList([0]));
console.log(addTwoNumbers(buildNodeList([1,8]), buildNodeList([0])));
