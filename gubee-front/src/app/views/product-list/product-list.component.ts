import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StackService } from 'app/service/stack.service';
import { TargetMarketService } from 'app/service/target-market.service';
import { Stack } from 'app/model/stack';
import { TargetMarket } from 'app/model/target-market';
import { ProductService } from 'app/service/product.service';
import { Product } from 'app/model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  stacks: Array<Stack>;
  targetMarkets: Array<TargetMarket>;
  products: Array<Product>;

  public formFiltro: FormGroup;
  constructor(public formBuider: FormBuilder,
              public stackService: StackService,
              public targetMarketService: TargetMarketService,
              public productService: ProductService) {

    this.formFiltro = this.formBuider.group({
        productName: [''],
        description: [''],
        stack: [],
        targetMarket: []
    })
  }

  ngOnInit() {
    this.stackService.getStacks().subscribe(response => this.stacks = response);
    this.targetMarketService.getTargetMarkets().subscribe(response => this.targetMarkets = response);
  }

  filtrar() {
    let filter = this.formFiltro.value;
    this.productService.applyFilter(filter).subscribe(data => {
      this.products = data;
    });
  }
}
