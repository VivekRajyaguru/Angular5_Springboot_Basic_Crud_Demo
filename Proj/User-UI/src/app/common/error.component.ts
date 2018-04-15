import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../Service/Notification.service';


@Component({
    selector: 'app-error',
    template: `<p-growl [(value)]="message" life="3000"></p-growl>`
})

export class NotificationComponent implements OnInit {
    message = [];
    constructor(private notificationService: NotificationService) {
        notificationService.ntfSubject$.subscribe(data => {
            this.showNotification(data);
        });
    }

    ngOnInit() { }

    showNotification(data) {
        if (data.type === 'error') {
            this.showError(data);
        } else if (data.type === 'info') {
            this.showInfo(data);
        } else if (data.type === 'warn') {
            this.showWarning(data);
        } else if (data.type === 'success') {
            this.showSuccessMessage(data);
        } else {
            return false;
        }
    }

    showInfo(data) {
        this.message.push({severity: 'info', summary: data.header, detail: data.detail});
    }

    showSuccessMessage(data) {
        this.message.push({severity: 'success', summary: data.header, detail: data.detail});
    }

    showError(data) {
        this.message.push({severity: 'error', summary: data.header, detail: data.detail});
    }

    showWarning(data) {
        this.message.push({severity: 'warn', summary: data.header, detail: data.detail});
    }
}
