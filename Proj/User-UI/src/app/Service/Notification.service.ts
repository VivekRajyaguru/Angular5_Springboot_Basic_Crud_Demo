import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class NotificationService {
    private ntfSubject = new Subject();

    ntfSubject$ = this.ntfSubject.asObservable();

    constructor() { }

    showNotification(messageHeader, messageDetail, type) {
        const data = {'header': messageHeader, 'detail': messageDetail, 'type': type};
        this.ntfSubject.next(data);
    }
}
