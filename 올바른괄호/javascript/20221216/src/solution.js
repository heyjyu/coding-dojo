function test() {
    console.log("correctParentheses('()()'): true = " + correctParentheses('()()'));
    console.log("correctParentheses(')()('): false = " + correctParentheses(')()('));
}

function solution(s){
   test();
    const answer = correctParentheses(s);

    return answer;
}

function correctParentheses(string) {
    const stack = [];

    for (let i = 0; i < string.length; i += 1) {
        if (string[i] === '(') {
            stack.push('(')

            continue;
        }

        if (stack.length === 0) {
            return false;
        }

        stack.pop();
    }

    return stack.length ? false : true;
}
