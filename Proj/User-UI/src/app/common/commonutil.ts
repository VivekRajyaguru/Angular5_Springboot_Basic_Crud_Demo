import { environment } from '../../environments/environment';


export class CommonUtil {

    static getApiEndPoints(): string {
        return environment.apiEndpoint;
    }

}
