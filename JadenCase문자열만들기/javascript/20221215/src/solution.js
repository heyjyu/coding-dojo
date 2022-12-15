function test() {
    console.log("isAlphabet('a'): true = " + isAlphabet('a'));
    console.log("isAlphabet(1): false = " + isAlphabet(1));

    console.log("toJadenCase('3people unFollowed me'): 3people Unfollowed Me = "
    + toJadenCase('3people unFollowed me'));
    console.log("toJadenCase('for the last week'): For The Last Week = "
        + toJadenCase('for the last week'));

    console.log("isFirstLetter({ index: 0, string: 'for the last week'}) = true : "
        + isFirstLetter({ index: 0, string: 'for the last week'}));
    console.log("isFirstLetter({ index: 4, string: 'for the last week'}) = true : "
        + isFirstLetter({ index: 4, string: 'for the last week'}));
    console.log("isFirstLetter({ index: 1, string: 'for the last week'}) = false : "
        + isFirstLetter({ index: 1, string: 'for the last week'}));
}

function solution(s) {
    test();
    var answer = toJadenCase(s);
    return answer;
}

function isAlphabet(character) {
    return 'A' <= character || character <= 'z';
}

function toJadenCase(string) {
    const lowerCasedString = string.toLowerCase();
    const characters = lowerCasedString.split('');

    return characters
        .map((character, i) => (isFirstLetter({ index: i, string })
                ? character.toUpperCase()
                : character
        ))
        .join('');
}

function isFirstLetter({ index, string }) {
    const characters = string.split('');

    if (isAlphabet(string[index])) {
        if (index === 0 || string[index - 1] === ' ') {
            return true;
        }
    }

    return false;
}
