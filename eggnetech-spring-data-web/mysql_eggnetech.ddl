CREATE USER 'eggnetech'@'localhost'
    identified by 'eggnetech';
GRANT ALL
    ON db_eggnetech.*
    TO 'eggnetech'@'localhost'
    WITH GRANT OPTION;

CREATE USER 'eggnetech'@'eggnetech.cn'
    identified by 'eggnetech';
GRANT ALL
    ON db_eggnetech.*
    TO 'eggnetech'@'eggnetech.cn'
    WITH GRANT OPTION;

CREATE USER 'eggnetech'@'eggnetech.com'
    identified by 'eggnetech';
GRANT ALL
    ON db_eggnetech.*
    TO 'eggnetech'@'eggnetech.com'
    WITH GRANT OPTION;



/**
  ## Make some security changes

  When you are on a production environment, you may be exposed to SQL injection attacks.
  A hacker may inject 'DROP TABLE' or any other destructive SQL commands. So as a security practice,
  you should make some changes to your database before you expose the application to your users.
 */
# The following command revokes all the priviliges from the user associated with the Spring Application:
# mysql -h eggnetech.cn -u root -p
revoke all on db_eggnetech.* from 'eggnetech'@'eggnetech.cn';
# The application must have some priviliges, so use the following command to grant the minimun priviliges the application needs:
grant select, insert, delete, update on db_eggnetech.* to 'eggnetech'@'eggnetech.cn';

