import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LessonComponent } from "./lesson/lesson.component";
import { MainComponent } from "./main/main.component";

const routes: Routes = [
	{path: ":id", component: MainComponent},
	{path: ":id/learn", component: LessonComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}