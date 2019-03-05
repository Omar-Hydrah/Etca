import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LessonComponent }   from "./lesson/lesson.component";
import { MainComponent }     from "./main/main.component";
import { ViewComponent }     from "./view/view.component";
import { AppComponent }      from "./app.component"; 
import { NotFoundComponent } from "./not-found/not-found.component";
import { BlankComponent }    from "./blank/blank.component";

const routes: Routes = [
	{path: "not-found", component: NotFoundComponent},
	{path: ":id", component: ViewComponent},
	{path: "", component: BlankComponent, pathMatch: "full"},
	{path: "**", component: NotFoundComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}