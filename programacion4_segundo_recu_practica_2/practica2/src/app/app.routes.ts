import { Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home-page';
import { List } from './pages/list/list';
import { Form } from './pages/form/form';
import { Details } from './pages/details/details';

export const routes: Routes = [
    {path: "", component: HomePage},
    {path: "list", component: List},
    {path: "create", component: Form},
    {path: "update/:id", component: Form},
    {path: "details/:id", component: Details},
    {path: "**", component: HomePage}
];
