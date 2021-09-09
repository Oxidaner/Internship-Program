
USE student_management;
create TABLE 'student' (
    'uid' varchar(40) NOT NULL Auto_INCMENT COMMENT '学号主键',
    'name' varchar(40) NOT NULL comment '用户名',
    'age' int COMMENT '年龄',
    'grade' varchar(20) COMMENT '年级',
    'dorm' int COMMENT '宿舍号',
    PRIMARY KEY ('uid')
)