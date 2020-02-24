import { StackResource } from "app/resource/stack-resouce";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
})
export class StackService {

    constructor(public stackResource: StackResource) {}

    public getStacks() {
        return this.stackResource.getStacks();
    }
}
