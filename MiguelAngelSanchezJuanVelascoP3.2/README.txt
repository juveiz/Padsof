Miguel Angel Sanchez and Juan Velasco.

- The main file is in the views package.
- Our application design is very simple (almost too simple) and we have recycled
  views and buttons for other views. So you will find buttons that should work
  in an specific situation (like cancel an approved offer) but the conditions
  are checked in the controllers
- In our application you can only go forward or backward. Sometimes you will go
  back more than you want (p.e: from any offer to the GuestHost menu) because
  it was easier to implement and it isn't very annoying
- The admin button "Change credit card" is the unban user. We call like that
  because a host user isn't banned when his card is wrong
- Everything an user do will be saved if he logs out. If not, the user
  will lose all the things
- In the main file you will found the admin user (1234) and the admin password
  (1234). By default, a GuestHost user is written in the login menu. The other
  users are in the clients example
