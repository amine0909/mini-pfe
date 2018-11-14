import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent }   from './dashboard/dashboard.component';
import { UserComponent }   from './user/user.component';
import { TableComponent }   from './table/table.component';
import { TypographyComponent }   from './typography/typography.component';
import { IconsComponent }   from './icons/icons.component';
import { MapsComponent }   from './maps/maps.component';
import { NotificationsComponent }   from './notifications/notifications.component';
import { UpgradeComponent }   from './upgrade/upgrade.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { NgModule } from '@angular/core';
import { ReclamationComponent } from './reclamation/reclamation.component';
import { LoginComponent } from './login/login.component';
import { AddReclamationComponent } from './add-reclamation/add-reclamation.component';

const AppRoutes: Routes = [
    {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'table',
        component: TableComponent
    },
    {
        path: 'typography',
        component: TypographyComponent
    },
    {
        path: 'icons',
        component: IconsComponent
    },
    {
        path: 'maps',
        component: MapsComponent
    },
    {
        path: 'notifications',
        component: NotificationsComponent
    },
    {
        path: 'upgrade',
        component: UpgradeComponent,   
    },
    {
        path: 'products',
        component: ListProductsComponent
    },
    {
        path: "reclamations",
        component: ReclamationComponent
    },
    {
        path: "add_reclamation",
        component: AddReclamationComponent
    },
    {
        path: "login",
        component: LoginComponent
    }
    
]

@NgModule({
    imports: [RouterModule.forRoot(AppRoutes)],
    exports: [RouterModule]
}) 
export class AppRoutingModule{}