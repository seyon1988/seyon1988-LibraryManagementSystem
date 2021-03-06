import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PARAMS } from '../params';
import { User } from "../user"
import { UserService } from "../user.service"
import { LiteratureService } from '../literature-service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  userID:number;

  users:User[];

  p:PARAMS = new PARAMS();

  showList:boolean = false;

  constructor(
    private literatureService:LiteratureService,
    private userService:UserService,
    private router:Router,
    private route:ActivatedRoute) { 
      this.userService.getUserByID(this.route.snapshot.params['aid']).subscribe(data => {
        this.p.setUserParameters(data);
      } , error => console.log(error));
    }

  ngOnInit(): void {

    this.getUsers();
  }

  getUsers(){
    this.showList = false;
    this.userID = null;
    this.userService.getUserList(). subscribe(data => {
      if(data.length!=0){
        this.users = data.sort((a,b)=> a.id-b.id);
        this.showList = true;;
      }else alert("No records found on database!");
      
    });
  }

  selectUser(){
    if(this.userID==null || this.userID==0  ){
      alert("Please type an id in text box");
      return;
    }
    this.userService.getUserByID(this.userID).subscribe( data => {
      this.users = [];
      this.users.push(data);
    } , error => {
      alert("No results found for your query");
      console.log(error)} );
  }

  updateUser(uhid :number){
    this.router.navigate(['updateuser',this.p.aid,uhid]);
  }

  deleteUser(uhid :number){
    this.userService.deleteUser(uhid). subscribe(data => {
      console.log(data);
      this.getUsers();
    });
  }

  viewUser(uid :number ){
    this.router.navigate(['viewuser' , this.p.aid , uid]);
  }



  login(){
    if(this.p.signedin==true){
      this.p.logoff();
      this.router.navigate(['welcome']); //signing out
    }else{
      this.router.navigate(['login']); // go to login page
    }
  }

  manageUsers(){
    this.router.navigate(['/manageusers',this.p.aid]);
  }

  goHome(){
    this.router.navigate(['member',this.p.aid]);
  }

  createUser(){
    this.router.navigate(['createuser' , this.p.aid]);
  }

  manageBooks(){
    this.router.navigate(['manageliteratures',this.p.aid]);
  }

  goToMyLoans(){
    this.router.navigate(['myloans',this.p.aid]);
  }

  manageLending(){
    this.router.navigate(['managelendings',this.p.aid]);
  }
  
  lendLiterature(uid:number){
    this.router.navigate(['lendliteratureu', this.p.aid, uid]);
  }
  

  viewBooks(){
    this.router.navigate(['viewliteratures',this.p.aid]);
  }


}
