import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LessonComponent } from "./lesson/lesson.component";
import { MainComponent } from "./main/main.component";
import { AppComponent } from "./app.component";

const routes: Routes = [
	{path: ":id", component: MainComponent},
	{path: ":id/learn", component: LessonComponent},
	{path: "", component: AppComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}