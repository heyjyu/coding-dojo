import addDigits from './solution';

test('addDigits', () => {
  expect(addDigits(123)).toBe(6);
  expect(addDigits(987)).toBe(24);
});
