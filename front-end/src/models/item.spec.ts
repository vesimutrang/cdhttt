import { CartItem } from './item';

describe('Item', () => {
  it('should create an instance', () => {
    expect(new CartItem(1,2)).toBeTruthy();
  });
});
