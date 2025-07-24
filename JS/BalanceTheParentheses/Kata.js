function fixParentheses(str) {
    let arr = str.split(""); //array
    let result = [];
    let lvl= 0;

    for( let x = 0; x < arr.length; x++)
    {
       
       if(arr[x] == "(")
       {
            lvl++;
       }
       else if( arr[x] == ')')
       {
            lvl--;   
       }
       
       if(lvl < 0)
       {
         lvl = 0;
         arr.splice(0,0,"(" );
         x=-1;
       }
    }

    while(lvl > 0)
    {
        arr.push(")");
        lvl--;
    }
    
    return arr.join(""); // "abc"
}

function checkIf(exp, ans) {
    const fixed = fixParentheses(exp);
    if (fixed === ans) {
        console.log("OK");
    } else {
        console.log("Not OK with:\n expected: " + ans + "\n got:      " + fixed);
    }
}

// Custom tests
checkIf('', '');
checkIf(')()))()())', '(((()()))()())');
checkIf(')))()(())', '((()))()(())');
checkIf('(()', '(())');
checkIf('()))()))(', '((((()))()))()');
checkIf(')(()(', '()(()())');
checkIf(')(()', '()(())');
checkIf(')(()))))())(((())', '((((()(()))))())(((())))');
checkIf(')))', '((()))');
checkIf(')(())(()()((())', '()(())(()()((())))');
checkIf(')(()((()))', '()(()((())))');
checkIf('()((())', '()((()))');
checkIf('(()', '(())');
checkIf('))()()((((()(())))', '(())()()((((()(())))))');
checkIf('))(())', '(())(())');