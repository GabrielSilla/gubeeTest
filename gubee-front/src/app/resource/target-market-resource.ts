import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Endpoint } from "app/utils/endpoint";
import { TargetMarket } from "app/model/target-market";

@Injectable()
export class TargetMarketResource {
    constructor(public httpClient: HttpClient) { }

    public getTargetMarkets() {
        return this.httpClient.get<Array<TargetMarket>>(Endpoint.url + '/target-market');
    }
}