import { TargetMarketResource } from "app/resource/target-market-resource";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
})
export class TargetMarketService {

    constructor(public stackResource: TargetMarketResource) {}

    public getTargetMarkets() {
        return this.stackResource.getTargetMarkets();
    }
}
