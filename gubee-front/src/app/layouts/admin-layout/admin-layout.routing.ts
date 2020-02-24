import { Routes } from '@angular/router';

import { ProductListComponent } from '../../views/product-list/product-list.component';
export const AdminLayoutRoutes: Routes = [
    { path: 'product-list',     component: ProductListComponent },
];
