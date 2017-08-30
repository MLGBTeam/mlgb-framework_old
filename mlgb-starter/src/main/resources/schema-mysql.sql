/*
初始化数据库脚本
*/
-- ----------------------------
-- 初始化版本信息表
-- ----------------------------
--  版本信息表
CREATE TABLE
IF NOT EXISTS `version` (
    `version`         INT(11) UNSIGNED NOT NULL
    COMMENT '数据库结构版本信息',
    `initialize_time` DATETIME         NOT NULL
    COMMENT '数据库结构初始化时间',
    `update_time`     DATETIME DEFAULT NULL
    COMMENT '数据库结构更新时间'
)
    ENGINE = INNODB
    DEFAULT CHARSET = utf8;
/*--SEPARATOR--*/

-- 版本信息操作历史表
CREATE TABLE
IF NOT EXISTS `version_history` (
    `version`      INT(11) UNSIGNED              NOT NULL
    COMMENT '数据库结构版本',
    `operate`      ENUM ('initialize', 'update') NOT NULL
    COMMENT '数据库结构操作（初始化、更新）',
    `operate_time` DATETIME                      NOT NULL
    COMMENT '数据库结构操作时间',
    PRIMARY KEY (`version`)
)
    ENGINE = INNODB
    DEFAULT CHARSET = utf8;
/*--SEPARATOR--*/

-- ----------------------------
-- 数据库版本信息脚本
-- ----------------------------
-- 初始化版本信息设置函数
DROP PROCEDURE
IF EXISTS execute_version_setting;
/*--SEPARATOR--*/
CREATE PROCEDURE execute_version_setting()
    BEGIN
        -- 查询当前版本,如果不存在版本信息就返回-1，存在则返回版本号
        SELECT (IF(COUNT(*) = 0, -1,
                   (SELECT `version`
                    FROM `version`)))
        INTO @version
        FROM
            `version`;
        -- 是否进行循环，当没有相对应的版本脚本时，退出循环
        SET @isLoop = TRUE;
        -- 操作标记（默认为更新）
        SET @operate = 'update';
        -- 原始版本号（用于判断是否进行了脚本操作）
        SET @original_version = @version;
        -- 循环
        WHILE @isLoop DO
            -- ----------------------------
            -- 如果当期版本信息为空，则初始化版本信息
            -- ----------------------------
            SET @version = @version + 1;
            CASE @version
                WHEN 0
                THEN
                    BEGIN
                        -- 插入一条版本为0的记录
                        INSERT INTO `version` (
                            `version`,
                            `initialize_time`,
                            `update_time`
                        )
                        VALUES
                            (0, NOW(), NULL);
                        SET @operate = 'initialize';
                    END;
            -- ----------------------------
            -- version 1
            -- ----------------------------
                WHEN 1
                THEN
                    BEGIN
                        SELECT 1;
                    END;
            -- ----------------------------
            -- version 2
            -- ----------------------------
                WHEN 2
                THEN
                    BEGIN
                        SELECT 2;
                    END;
            -- ----------------------------
            -- version 3
            -- ----------------------------
                WHEN 3
                THEN
                    BEGIN
                        SELECT 3;
                    END;
            -- ----------------------------
            -- 最终数据处理
            -- ----------------------------
            ELSE
                BEGIN
                    -- 判断是否进行了脚本操作
                    IF (@version - 1) != @original_version
                    THEN
                        -- 修改版本信息
                        UPDATE `version`
                        SET `version` = @version - 1, `update_time` = NOW();
                        -- 插入版本信息操作历史表
                        INSERT INTO `version_history` (
                            `version`,
                            `operate`,
                            `operate_time`
                        )
                        VALUES
                            (@version - 1, @operate, NOW());
                    END IF;
                    SET @isLoop = FALSE;
                END;
            END CASE;
        END WHILE;
    END;
/*--SEPARATOR--*/
-- 执行版本信息设置
CALL execute_version_setting();
/*--SEPARATOR--*/