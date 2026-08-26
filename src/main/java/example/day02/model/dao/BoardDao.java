package example.day02.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import example.day02.model.dto.BoardDto;

public class BoardDao extends BaseDao{

    private BoardDao(){};
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){return instance;}
 
 
 	
    // [1] 등록 
    public boolean save( BoardDto boardDto ){
        try{// 1. SQL 작성
            String sql = "insert into board( content, writer ) values( ? , ? )";
            // 2. SQL 기재( SQL은 자바가 아니고 외부(MYSQL서버) 전달 )
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3. 기재된 SQL에 매개변수 대입 , ps.set타입( ?순서번호 , 입력받은값 )
            ps.setString( 1 , boardDto.getContent() );
            ps.setString( 2 , boardDto.getWriter() );
            // 4. 기재된 SQL 실행, ps.execute() 단순실행 , .executeUpdate() 실행후반영된레코드수반환
            int result = ps.executeUpdate();
            // 5. SQL 실행 결과
            if( result == 1 ){ return true; } // 만약에 레코드 등록이 1개 되었다면 성공 true
        }catch(Exception e ){ System.out.println( e ); }
        return false; // 등록 실패시 false 
    }

    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> boardDtos = new ArrayList<>();
        try{
            String sql = "select * from board";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                BoardDto boardDto = new BoardDto(rs.getInt("no"), rs.getString("content"), rs.getString("writer"));
                boardDtos.add(boardDto);
            }
        }catch(SQLException e){System.out.println(e);}

        return boardDtos;
    }

    public boolean update(int no, String content){

        try{
            String sql = "UPDATE board SET content = ? WHERE no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, content);
            ps.setInt(2, no);

            int result = ps.executeUpdate();

            if (result == 1){
                return true;
            }
        }catch(SQLException e){System.out.println(e);}

        return false;
    }

    public boolean delete(int no){
        
        try{
            String sql = "DELETE FROM board WHERE no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, no);

            int result = ps.executeUpdate();

            if (result == 1){
                return true;
            }
        }catch(SQLException e){System.out.println(e);}
        return false;
    }

}
