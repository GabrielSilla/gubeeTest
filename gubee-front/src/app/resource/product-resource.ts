import { Product } from "app/model/product";
import { Endpoint } from "app/utils/endpoint";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class ProductResource {
    constructor(public httpClient: HttpClient) { }

    public applyFilter(filter: any) {
        return this.httpClient.post<Array<Product>>(Endpoint.url + '/product/filter', filter);
    }
}
