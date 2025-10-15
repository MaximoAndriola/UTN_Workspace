import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { List } from './pages/list/list';
import { Form } from './pages/form/form';
import { FormEdit } from './pages/form-edit/form-edit';
import { Detail } from './pages/detail/detail';

export const routes: Routes = [
    {path:'', component: Home},
    {path:'movies', component: List},
    {path:'movies/:movieId', component: Detail},
    {path:'addMovie', component: Form},
    {path:'updateMovie/:movieId', component: FormEdit},
    {path:'**', redirectTo: '/home'}
];
