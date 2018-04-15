import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { NotificationService } from './Notification.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';


@Injectable()
export class CustomHttpService {
    constructor(private httpClient: HttpClient, private notificationService: NotificationService) { }

    post(url, body): Observable<any> {
        const requestOptions = this.createRequestOptions();
        return this.httpClient.post(url, body, requestOptions)
            .map(response => {
                return response;
            }
            ).catch((err) => {
                this.notificationService.showNotification('error', '', 'error');
                return Observable.throw(err);
            });
    }

    get(url): Observable<any> {
        const requestOptions = this.createRequestOptions();
        return this.httpClient.get(url, requestOptions)
            .map(response => {

            }).catch((err) => {
                return Observable.throw(err);
            });
    }

    createRequestOptions(): any {
        const headers = new HttpHeaders().append('Content-Type', 'application/json').append('Accept', 'application/json');
        const requestOptions = {
            'headers': headers
        };
        return requestOptions;
    }

}
