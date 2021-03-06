import { Injectable } from '@angular/core';
import { CustomHttpService } from './CustomHttp.service';
import { Observable } from 'rxjs/Rx';
import { CommonUtil } from '../common/commonutil';
import { DataTableParam } from '../Model/DataTableParam';

@Injectable()
export class UserService {

    constructor(private customHttpService: CustomHttpService) { }

    saveUser(object: any): Observable<any> {
        const url = CommonUtil.getApiEndPoints() + '/user/add';
        const body = JSON.stringify({valueObject: object});
        return this.customHttpService.post(url, body);
    }

    listUser(dataTableParam: DataTableParam): Observable<any> {
        const url = CommonUtil.getApiEndPoints() + '/user/list';
        const body = JSON.stringify({'dataTableParam': dataTableParam});
        return this.customHttpService.post(url, body);
    }

    loadUserById(id: any): Observable<any> {
        const url = CommonUtil.getApiEndPoints() + '/user/loadUserById';
        const body = JSON.stringify({valueObject: id});
        return this.customHttpService.post(url, body);
    }

    deleteUser(id: any): Observable<any> {
        const url = CommonUtil.getApiEndPoints() + '/user/delete';
        const body = JSON.stringify({valueObject: id});
        return this.customHttpService.post(url, body);
    }

}
