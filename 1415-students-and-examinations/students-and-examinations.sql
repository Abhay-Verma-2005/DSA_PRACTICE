SELECT st.student_id,st.student_name,ss.subject_name,Count(e.subject_name) as attended_exams
FROM Students st JOIN Subjects ss
LEFT JOIN Examinations e
ON e.student_id = st.student_id
AND ss.subject_name = e.subject_name
GROUP BY st.student_id,ss.subject_name
Order BY st.student_id ;