import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { List } from './pages/list/list';
import { Details } from './pages/details/details';
import { UpdateForm } from './pages/update-form/update-form';
import { Form } from './pages/form/form';

export const routes: Routes = [
    {path: "", component: Home},
    {path: "list", component: List},
    {path: "details/:movieId", component: Details},
    {path: "add", component: Form},
    {path: "update/:movieId", component: UpdateForm},
    {path: "**", component: Home}
];
