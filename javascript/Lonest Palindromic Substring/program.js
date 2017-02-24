
// solution 1 穷举 O(n³)
var longestPalindrome = function(s) {
  var max = 0;
  var begin = 0;
  var len = s.length;
  var i =0, k = 0, j = 0;
  if (s.length == 1) { return s;}

  for (i = 0; i < len; i++) {
    for (j = i+1; j < len; j++) {

      for(k = 0; k < parseInt((j - i + 1) / 2); k++) {
        if (s[i + k] != s[j - k]) { break;}
      }

      //console.log('s: %s i: %s, j: %s', s.substring(i, j+1), i, j);

      if (k == parseInt(((j-i+1) / 2))) {

        if (j - i + 1 > max - begin) { max = j, begin  = i;}
        //console.log('%s 是回文数', s.substring(i,j+1));
      }
    }
  }

  return s.substring(begin, max + 1);
}

console.log(longestPalindrome(process.argv[2]));
