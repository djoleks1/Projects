import { RecordStorePage } from './app.po';

describe('record-store App', function() {
  let page: RecordStorePage;

  beforeEach(() => {
    page = new RecordStorePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
