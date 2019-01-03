import { TestBed } from '@angular/core/testing';

import { CanActivateAdminService } from './can-activate-admin.service';

describe('CanActivateAdminService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CanActivateAdminService = TestBed.get(CanActivateAdminService);
    expect(service).toBeTruthy();
  });
});
