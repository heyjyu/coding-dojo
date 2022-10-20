import { changeCase, lowerCaseAtOddIndex } from './solution';

test('changeCase', () => {
  expect(changeCase('try hello world')).toBe('TrY HeLlO WoRlD');
});

test('lowerCaseAtOddIndex', () => {
  expect(lowerCaseAtOddIndex('AABBCC')).toBe('AaBbCc');
  expect(lowerCaseAtOddIndex('TRY HELLO WORLD')).toBe('TrY HeLlO WoRlD');
});
