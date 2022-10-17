function solution(n) {
    const number = n.toString();
    
    return [...Array(number.length).keys()]
        .map(i => parseInt(number[number.length - i - 1]));
}
