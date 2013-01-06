package org.mynah.brew.jdbc;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mynah.brew.jdbc.Template;
import org.mynah.brew.model.Jdbc;
import org.mynah.brew.util.ConstantsTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(ConstantsTest.CONTEXT)
public class TemplateTest {

    @Autowired
    private Template template;

    @Autowired
    private DataSource dataSource;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // TODO before先建立这样一张测试表，after再删除
    }

    @Test
    public void testTemplate() {
        new Template();
    }

    @Test
    public void testTemplateDataSource() {
        new Template(dataSource);
    }

    @Test
    public void testTemplateDataSourceBoolean() {
        new Template(dataSource, false);
    }

    @Test
    public void testInitNamedJdbcTemplate() {
    }

    @Test
    public void testUpdateStringSqlParameterSourceKeyHolder() {
    }

    @Test
    public void testQuery() throws Exception {
        Jdbc jdbc = new Jdbc();
        List<Jdbc> jdbcs = template.query(jdbc, Jdbc.class);
        int count = template.queryForInt("select count(id) from jdbc");
        assertThat(jdbcs.size(), is(count));
        Jdbc j = new Jdbc();
        j.setAbbr("sfjsljfsoeifjsljflsjfeijfslfjieiwlzncxkkfdksl");
        jdbcs = template.query(j, Jdbc.class);
        assertThat(jdbcs.size(), is(0));
    }

    @Test
    public void testQueryForObject() throws Exception {
        Jdbc jdbc = new Jdbc();
        Jdbc j = new Jdbc();
        j.setAbbr("testQueryForObject");
        j.setName("testQueryForObject");
        j.setContent("testQueryForObject");
        j.setCreateBy(-1);
        j.setCreateDate(new Date());
        jdbc.setId(template.insert(j));
        assertNotNull(template.queryForObject(jdbc, Jdbc.class));
    }

    @Test
    public void testInsert() throws Exception {
        Jdbc jdbc = new Jdbc();
        jdbc.setModifyDate(new Date());
        int id = template.queryForInt("select max(id) + 1 from jdbc");
        assertThat(template.insert(jdbc), is(id));
        Jdbc j = new Jdbc();
        j.setAbbr("ZHONGWEN");
        id = template.queryForInt("select max(id) + 1 from jdbc");
        assertThat(template.insert(j), is(id));
        Jdbc empty = new Jdbc();
        assertThat(template.insert(empty), is(0));
    }

    @Test
    public void testDelete() throws Exception {
        Jdbc jdbc = new Jdbc();
        jdbc.setId(Integer.MAX_VALUE);
        assertThat(template.delete(jdbc), is(0));
    }

    @Test
    public void testUpdate() throws Exception {
        Jdbc where = new Jdbc();
        where.setId(Integer.MAX_VALUE);
        Jdbc jdbc = new Jdbc();
        jdbc.setAbbr("aa");
        jdbc.setName("bbbb");
        assertThat(template.update(where, jdbc), is(0));
        Jdbc j = new Jdbc();
        j.setAbbr("aa");
        assertThat(template.update(where, j), is(0));
        Jdbc jd = new Jdbc();
        jd.setName("bbbb");
        assertThat(template.update(where, jd), is(0));
        Jdbc jdb = new Jdbc();
        assertThat(template.update(where, jdb), is(0));
    }
}
