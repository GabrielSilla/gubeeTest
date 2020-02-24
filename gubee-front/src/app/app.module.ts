import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';


import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './views/components/components.module';

import { AppComponent } from './app.component';
import {
  AgmCoreModule
} from '@agm/core';
import { AdminLayoutComponent } from './views/layouts/admin-layout/admin-layout.component';
import { StackService } from './service/stack.service';
import { HttpClientModule } from '@angular/common/http';
import { StackResource } from './resource/stack-resouce';
import { TargetMarketResource } from './resource/target-market-resource';
import { TargetMarketService } from './service/target-market.service';
import { ProductService } from './service/product.service';
import { ProductResource } from './resource/product-resource';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    HttpClientModule,
    ComponentsModule,
    RouterModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
    })
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
  ],
  providers: [
    ProductResource,
    TargetMarketResource,
    StackResource,
    ProductService,
    TargetMarketService,
    StackService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
