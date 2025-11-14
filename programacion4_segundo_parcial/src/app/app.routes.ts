import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { List } from './pages/list/list';
import { Details } from './pages/details/details';
import { Form } from './pages/form/form';

export const routes: Routes = [
    {path: "", component: Home},
    {path: "list", component: List},
    {path: "details/:clientId", component: Details},
    {path: "form", component: Form},
    {path: "form/:clientId", component: Form},
    {path: "**", component: Home}
];
