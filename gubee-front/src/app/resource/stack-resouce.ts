import { HttpClient } from "@angular/common/http";
import { Endpoint } from "app/utils/endpoint";
import { Observable } from "rxjs";
import { Stack } from "app/model/stack";
import { Injectable } from "@angular/core";

@Injectable()
export class StackResource {
    constructor(public httpClient: HttpClient) { }

    public getStacks() {
        return this.httpClient.get<Array<Stack>>(Endpoint.url + '/stack');
    }
}
