package tw.com.ispan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.domain.ChatRecord;
import tw.com.ispan.domain.Members;

@Repository
public interface ChatRecordRepository extends JpaRepository<ChatRecord, Long> {
    // 查詢某個會員的聊天記錄，按時間順序排列
    List<ChatRecord> findByMember_MembersIdOrderByTimestampAsc(Integer memberId);

    // 根據 sessionId 查詢聊天記錄
    List<ChatRecord> findBySessionIdOrderByTimestampAsc(String sessionId);
    // 根據會員查詢聊天紀錄，並按時間排序
    List<ChatRecord> findByMemberOrderByTimestampAsc(Members member);
}
