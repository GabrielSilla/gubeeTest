import { ProductResource } from "app/resource/product-resource";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root',
})
export class ProductService {

    constructor(public productResource: ProductResource) {}

    public applyFilter(filter: any) {
        return this.productResource.applyFilter(filter);
    }
}