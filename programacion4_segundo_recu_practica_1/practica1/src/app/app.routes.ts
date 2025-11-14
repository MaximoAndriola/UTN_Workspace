import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { List } from './pages/list/list';
import { Form } from './pages/form/form';
import { Details } from './pages/details/details';

export const routes: Routes = [
    {path: "", component: Home},
    {path: "list", component: List},
    {path: "create", component: Form},
    {path: "details/:id", component: Details},
    {path: "update/:id", component: Form},
    {path: "**", component: Home}
];
