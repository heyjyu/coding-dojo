import convert, { moveCharacter } from './solution';

test('moveCharacter', () => {
  expect(moveCharacter({ character: 'A', times: 1 })).toBe('B');
  expect(moveCharacter({ character: 'Z', times: 1 })).toBe('A');
  expect(moveCharacter({ character: 'z', times: 1 })).toBe('a');
  expect(moveCharacter({ character: 'y', times: 2 })).toBe('a');
  expect(moveCharacter({ character: 'a', times: 2 })).toBe('c');
  expect(moveCharacter({ character: 'a', times: 25 })).toBe('z');
});

test('convert', () => {
  expect(convert({ string: 'AB', times: 1 })).toBe('BC');
  expect(convert({ string: 'z', times: 1 })).toBe('a');
  expect(convert({ string: 'a B z', times: 4 })).toBe('e F d');
  expect(convert({ string: ' a B z ', times: 4 })).toBe(' e F d ');
  expect(convert({ string: ' a B z ', times: 25 })).toBe(' z A y ');
});
