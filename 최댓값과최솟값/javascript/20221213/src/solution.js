function test() {
    console.log('min("1 2 3 4"): 1 = ' + min("1 2 3 4"));
    console.log('max("1 2 3 4"): 4 = ' + max("1 2 3 4"));
    console.log('minAndMax("1 2 3 4"): 1 4 = ' + minAndMax("1 2 3 4"));
}

function solution(s) {
    test();
    var answer = '';
    return answer;
}

function min(string) {
    return Math.min(...string.split(' '));
}

function max(string) {
    return Math.max(...string.split(' '));
}

function minAndMax(string) {
    return min(string) + ' ' + max(string);
}
